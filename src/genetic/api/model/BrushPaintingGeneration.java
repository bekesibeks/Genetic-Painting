package genetic.api.model;

import genetic.api.evolution.Generation;
import genetic.api.evolution.Individual;

public class BrushPaintingGeneration implements Generation {

	private BrushPaintingIndividual parent;
	private BrushPaintingIndividual children;

	public BrushPaintingGeneration() {
		parent = new BrushPaintingIndividual();
	}

	@Override
	public void mutate() {
		children = new BrushPaintingIndividual(parent);
		children.mutate();
	}

	@Override
	public void repopulate() {
		updateFitness();
		if (children.getFitness() > parent.getFitness()) {
			parent = new BrushPaintingIndividual((BrushPaintingIndividual) children);
		}

	}

	@Override
	public Individual getFittestIndividual() {
		return parent;
	}

	private void updateFitness() {
		parent.calculateFitness();
		children.calculateFitness();
	}

}
