package genetic.api.model;

import static genetic.config.CommonConfig.NUMBER_OF_POPULATION;
import static genetic.config.CommonConfig.SELECTION_AMOUNT;
import static genetic.utility.RandomUtility.randomGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import genetic.api.evolution.Generation;
import genetic.api.evolution.Individual;

public class BrushPaintingGeneration implements Generation {

	private List<Individual> population = new ArrayList<>();

	public BrushPaintingGeneration() {
		for (int i = 0; i < NUMBER_OF_POPULATION; i++) {
			BrushPaintingIndividual brushPaintingIndividual = new BrushPaintingIndividual();
			population.add(brushPaintingIndividual);
		}
	}

	@Override
	public List<Individual> selection() {
		updateFitness();
		Collections.sort(population);

		List<Individual> selectedPopulation = new ArrayList<>();

		for (int i = 0; i < NUMBER_OF_POPULATION * (double)(SELECTION_AMOUNT / 100.0d); i++) {
			Individual selected = population.get(randomGenerator.nextInt(population.size() / 2));
			selectedPopulation.add(new BrushPaintingIndividual((BrushPaintingIndividual) selected));
		}

		return selectedPopulation;
	}

	@Override
	public List<Individual> crossover(List<Individual> parents) {
		Collections.shuffle(parents);
		List<Individual> newbornIndividuals = new ArrayList<>();
		for (int i = 0; i < parents.size(); i += 2) {
			Individual newborn = parents.get(i).crossover(parents.get(i + 1));
			newbornIndividuals.add(newborn);
		}

		return newbornIndividuals;
	}

	@Override
	public List<Individual> mutate(List<Individual> individuals) {
		individuals.stream().forEach(individual -> individual.mutate());
		return individuals;
	}

	@Override
	public void repopulate(List<Individual> newbornIndividuals) {
		for (int i = 0; i < newbornIndividuals.size(); i++) {
			population.remove(population.size()-1);
		}
		population.addAll(newbornIndividuals);
	}

	@Override
	public Individual getFittestIndividual() {
		updateFitness();
		Collections.sort(population);
		long fitness = population.get(0).getFitness();
		long fitness2 = population.get(1).getFitness();
		System.out.println(fitness + " --"+fitness2);
		return population.get(0);
	}

	private void updateFitness() {
		population.stream().forEach(individual -> individual.calculateFitness());
	}

}
