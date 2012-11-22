package org.somox.metrics.basic;

import java.util.Set;

import org.somox.metrics.AbstractCountingMetric;
import org.somox.metrics.ClusteringRelation;
import org.somox.metrics.MetricID;

import de.fzi.gast.types.GASTClass;

public class InternalAccessesCount extends AbstractCountingMetric {

	public final static MetricID METRIC_ID = new MetricID("org.somox.metrics.basic.InternalAccessesCount");
	
	@Override
	protected ClusteringRelation internalComputeDirected (
			ClusteringRelation relationToCompute) {
		Set<GASTClass> classes1 = this.getComponentToClassHelper().deriveImplementingClasses(relationToCompute.getComponentA());
		Set<GASTClass> classes2 = this.getComponentToClassHelper().deriveImplementingClasses(relationToCompute.getComponentB());
			
		relationToCompute.setResultMetric(getMID(), 
			(double)getAccessGraphCache().calculateNumberOfAccessesToClassesInSet(
							classes1, classes2));
		return relationToCompute;
	}

	@Override
	public MetricID getMID() {
		return METRIC_ID;
	}

	@Override
	public boolean isCommutative() {
		return false;
	}

}