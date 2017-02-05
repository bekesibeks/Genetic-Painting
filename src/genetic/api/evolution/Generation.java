package genetic.api.evolution;

public interface Generation {
	
	void makeEvolutionStep();
	
	Individual getFittestIndividual();
	
}
