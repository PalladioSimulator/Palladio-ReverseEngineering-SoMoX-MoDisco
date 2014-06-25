package org.somox.metrics.dslvisitor;

import org.somox.metrics.IMetric;
import org.somox.metrics.dsl.metricDSL.InternalMetric;
import org.somox.metrics.dsl.metricDSL.Metric;
import org.somox.metrics.dsl.metricDSL.RatioMetric;
import org.somox.metrics.dsl.metricDSL.StepwiseMetric;
import org.somox.metrics.dsl.metricDSL.WeightedMetric;
import org.somox.metrics.dsl.metricDSL.util.MetricDSLSwitch;

public class DSLConfigurationVisitor extends MetricDSLSwitch<IMetric> {

    /* (non-Javadoc)
     * @see org.somox.metrics.dSL.util.DSLSwitch#caseMetric(org.somox.metrics.dSL.Metric)
     */
    @Override
    public IMetric caseInternalMetric(final InternalMetric object) {
        if (object.getDefinition() == null) {
            return null;
        }
        return this.doSwitch(object.getDefinition());
    }

    /* (non-Javadoc)
     * @see org.somox.metrics.dSL.util.DSLSwitch#caseRatioMetric(org.somox.metrics.dSL.RatioMetric)
     */
    @Override
    public IMetric caseRatioMetric(final RatioMetric object) {
        return new ConfigurableRatioMetric(
                ((Metric)object.eContainer()).getName(),
                object);
    }

    /* (non-Javadoc)
     * @see org.somox.metrics.dSL.util.DSLSwitch#caseStepwiseMetric(org.somox.metrics.dSL.StepwiseMetric)
     */
    @Override
    public IMetric caseStepwiseMetric(final StepwiseMetric object) {
        return new ConfigurableStepwiseMetric(
                ((Metric)object.eContainer()).getName(),
                object);
    }

    /* (non-Javadoc)
     * @see org.somox.metrics.dSL.util.DSLSwitch#caseWeightedMetric(org.somox.metrics.dSL.WeightedMetric)
     */
    @Override
    public IMetric caseWeightedMetric(final WeightedMetric object) {
        return new ConfigurableWeightedComposedMetric(
                ((Metric)object.eContainer()).getName(),
                object);
    }
}
