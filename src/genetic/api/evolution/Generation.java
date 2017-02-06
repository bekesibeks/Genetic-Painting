package genetic.api.evolution;

public interface Generation {

	void mutate();

	void repopulate();

	Individual getFittestIndividual();

}
