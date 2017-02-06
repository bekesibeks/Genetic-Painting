package genetic.api.model;

import static genetic.config.CommonConfig.AMOUNT_OF_MUTATION;
import static genetic.config.CommonConfig.CHANCE_TO_ADD_NEW_BRUSH;
import static genetic.config.IndividualsConfig.MAX_NUMBER_OF_CURVES;
import static genetic.factories.CurveFactory.getRandomCurve;
import static genetic.utility.FitnessCalculator.calculateRgbDifference;
import static genetic.utility.RandomUtility.randomGenerator;
import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.List;

import genetic.api.evolution.Chromosome;
import genetic.api.evolution.Individual;
import genetic.factories.CurveFactory;
import view.model.BrushPaintingView;

public class BrushPaintingIndividual implements Individual {

	private List<Chromosome> curves;
	private long fitness;

	public BrushPaintingIndividual() {
		curves = new ArrayList<>();

		addFirstCurve();
	}

	public BrushPaintingIndividual(BrushPaintingIndividual source) {
		fitness = source.fitness;
		curves = new ArrayList<>();

		source.getChromosomes().forEach(curve -> curves.add(new BrushPaintingCurve((BrushPaintingCurve) curve)));
	}

	@Override
	public Individual crossover(Individual otherIndividual) {
		List<Chromosome> otherChromosomes = otherIndividual.getChromosomes();
		List<Chromosome> mixedChromosomes = new ArrayList<>();

		for (int i = 0; i < min(otherChromosomes.size(), curves.size()); i++) {
			if (randomGenerator.nextBoolean()) {
				mixedChromosomes.add(curves.get(i));
			} else {
				mixedChromosomes.add(otherChromosomes.get(i));
			}
		}

		BrushPaintingIndividual child = new BrushPaintingIndividual();
		child.setChromosomes(mixedChromosomes);

		return child;
	}

	@Override
	public void mutate() {
		curves.stream().filter((curve) -> randomGenerator.nextDouble() < AMOUNT_OF_MUTATION)
				.forEach(Chromosome::mutate);

		if (randomGenerator.nextDouble() < CHANCE_TO_ADD_NEW_BRUSH) {
			if (curves.size() < MAX_NUMBER_OF_CURVES) {
				curves.add(CurveFactory.getRandomCurve());
			}
		}
	}

	@Override
	public void calculateFitness() {
		BrushPaintingView view = new BrushPaintingView();
		view.buildModelFrom(this);
		fitness = calculateRgbDifference(view.getModel());
	}

	@Override
	public long getFitness() {
		return fitness;
	}

	@Override
	public int compareTo(Individual arg0) {
		return Long.compare(arg0.getFitness(), fitness);
	}

	@Override
	public List<Chromosome> getChromosomes() {
		return curves;
	}

	public void setChromosomes(List<Chromosome> curves) {
		this.curves = curves;
	}

	private void addFirstCurve() {
		curves.add(getRandomCurve());
	}

}
