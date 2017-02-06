package genetic.managerimpl;

import java.util.List;

import genetic.api.evolution.Generation;
import genetic.api.evolution.GeneticAlgorithmManager;
import genetic.api.evolution.Individual;

public class GeneticAlgorithmManagerImpl implements GeneticAlgorithmManager{
	
	private Generation generation;
		
	public GeneticAlgorithmManagerImpl(Generation generation) {
		this.generation = generation;
	}
	
	
	@Override
	public void makeEvolutionStep() {
		long startTime = System.currentTimeMillis();    
		List<Individual> selectedIndividuals = generation.selection();
		System.out.println("Selected : "+selectedIndividuals.size());
		List<Individual> newbornIndividuals = generation.crossover(selectedIndividuals);
		System.out.println("newboen : "+newbornIndividuals.size());
		List<Individual> mutatedNewBorns = generation.mutate(newbornIndividuals);
		System.out.println("mutatedNewBorns : "+mutatedNewBorns.size());
		generation.repopulate(mutatedNewBorns);
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println(estimatedTime);
	}

	@Override
	public Individual getFittestIndividual() {
		return generation.getFittestIndividual();
	}
	
	
}
