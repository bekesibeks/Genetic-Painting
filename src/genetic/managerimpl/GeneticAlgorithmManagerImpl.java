package genetic.managerimpl;

import genetic.api.evolution.Generation;
import genetic.api.evolution.GeneticAlgorithmManager;
import genetic.api.evolution.Individual;

public class GeneticAlgorithmManagerImpl implements GeneticAlgorithmManager {
	
	private static long generationNumber = 0;
	
	private Generation generation;

	public GeneticAlgorithmManagerImpl(Generation generation) {
		this.generation = generation;
	}

	@Override
	public void makeEvolutionStep() {
		generationNumber++;
		long startTime = System.currentTimeMillis();
		generation.mutate();
		generation.repopulate();
		Individual fittestIndividual = generation.getFittestIndividual();

		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println(generationNumber+"# Repopulated..time spent : " + estimatedTime+" fitness : "+fittestIndividual.getFitness()/100000);
	}

	@Override
	public Individual getFittestIndividual() {
		return generation.getFittestIndividual();
	}

}
