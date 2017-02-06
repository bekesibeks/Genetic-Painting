package genetic.api.evolution;

import java.util.List;

public interface Individual extends Comparable<Individual> {
	
	Individual crossover(Individual otherIndividual);
	
	void mutate();

	void calculateFitness();

	long getFitness();
	
	List<Chromosome> getChromosomes();
}
