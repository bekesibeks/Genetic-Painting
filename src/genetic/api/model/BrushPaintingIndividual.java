package genetic.api.model;

import static genetic.config.CommonConfig.AMOUNT_OF_MUTATION;
import static genetic.config.CommonConfig.CHANCE_TO_ADD_NEW_CIRCLE;
import static genetic.config.IndividualsConfig.MAX_NUMBER_OF_CURVES;
import static genetic.factories.CircleFactory.getRandomCircle;
import static genetic.utility.FitnessCalculator.calculateRgbDifference;
import static genetic.utility.RandomUtility.randomGenerator;
import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.List;

import genetic.api.evolution.Chromosome;
import genetic.api.evolution.Individual;
import genetic.config.CommonConfig;
import genetic.factories.CircleFactory;
import view.model.BrushPaintingView;

public class BrushPaintingIndividual implements Individual {

	private List<Chromosome> circles;
	private long fitness;

	public BrushPaintingIndividual() {
		circles = new ArrayList<>();

		addFirstCircles();
	}

	public BrushPaintingIndividual(BrushPaintingIndividual source) {
		fitness = source.fitness;
		circles = new ArrayList<>();

		source.getChromosomes().forEach(curve -> circles.add(new PaintingCircle((PaintingCircle) curve)));
	}

	@Override
	public Individual crossover(Individual otherIndividual) {
		List<Chromosome> otherChromosomes = otherIndividual.getChromosomes();
		List<Chromosome> mixedChromosomes = new ArrayList<>();

		int newSize = min(otherChromosomes.size(), circles.size());

		for (int i = 0; i < newSize; i++) {
			if (i < newSize / 2) {
				mixedChromosomes.add(circles.get(i));
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

		if (randomGenerator.nextDouble() < CommonConfig.CHANCE_TO_ADD_NEW_CIRCLE) {
			circles.add(getRandomCircle());
		} else {
			circles.stream().filter((circle) -> randomGenerator.nextDouble() < AMOUNT_OF_MUTATION)
					.forEach(Chromosome::mutate);
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
		return circles;
	}

	public void setChromosomes(List<Chromosome> circles) {
		this.circles = circles;
	}

	private void addFirstCircles() {
		for (int i = 0; i < 1; i++) {
			circles.add(getRandomCircle());
		}
	}

}
