package genetic.api.evolution;

public interface GeneticAlgorithmManager {
		
	void makeEvolutionStep();
	
	Individual getFittestIndividual();
	
}
