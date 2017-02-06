package genetic.api.evolution;

import java.util.List;

public interface Generation {

	List<Individual> selection();

	List<Individual> crossover(List<Individual> parents);

	List<Individual> mutate(List<Individual> individuals);

	void repopulate(List<Individual> newbornIndividuals);

	Individual getFittestIndividual();

}
