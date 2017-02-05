package genetic.api.evolution;

public interface Individual extends Comparable<Individual> {
	
	Individual crossover(Individual otherIndividual);
	
	void mutate();

	void calculateFitness();

	long getFitness();
}
