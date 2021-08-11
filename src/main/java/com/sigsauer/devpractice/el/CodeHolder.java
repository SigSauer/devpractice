package com.sigsauer.devpractice.el;

import java.util.Objects;

public class CodeHolder {

    int a;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeHolder that = (CodeHolder) o;
        return a == that.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    //    private <T> T value(Object o, Class<T> c) {
//        Object def;
//        if(c.isInstance(o)) {
//            def =  o;
//        }else {
//            def =   c == Double.class ? 0. :
//                    c == Integer.class ? 0 :
//                    c == TermsPeriod.class ? TermsPeriod.INF :
//                    c == AccrualStrategy.class ? AccrualStrategy.INF :
//                    ProlongationStrategy.INF;
//        }
//        return (T) def;
//    }


//
//    default Map<ProductProperty, Map<String, Object>> map(Map<String, Map<String, Object>> parameters) {
//        Map<ProductProperty, Map<String, Object>> local = new HashMap<>();
//        for (String s: parameters.keySet()) {
//                Map<String, String> expectedValues = Map.copyOf(parameters.get(s));
//                switch (ProductProperty.valueOf(s)) {
//                    case AMOUNT:
//                        local.put(AMOUNT, setAmount(
//                                Double.valueOf(expectedValues.get("min")),
//                                Double.valueOf(expectedValues.get("max")))
//                        );
//                        break;
//                    case TERMS:
//                        local.put(TERMS, setTerms(
//                                TermsPeriod.valueOf(expectedValues.get("period")),
//                                Integer.valueOf(expectedValues.get("min")),
//                                Integer.valueOf(expectedValues.get("max")))
//                        );
//                        break;
//                    case FEE:
//                        local.put(FEE, setFee(
//                                AccrualStrategy.valueOf(expectedValues.get("strategy")),
//                                Double.valueOf(parameters.get(s).get("fee")))
//                        );
//                        break;
//                    case RATE:
//                        m.put(RATE, setRate(
//                                AccrualStrategy.valueOf(expectedValues.get("strategy")),
//                                Double.valueOf(parameters.get(s).get("rate")))
//                        );
//                        break;
//                    case PENALTY:
//                        m.put(PENALTY, setPenalty(
//                                AccrualStrategy.valueOf(expectedValues.get("strategy")),
//                                Double.valueOf(parameters.get(s).get("penalty")))
//                        );
//                        break;
//                    case PROLONGATION_ORDER:
//                        m.put(PROLONGATION_ORDER, setProlongationOrder(
//                                ProlongationStrategy.valueOf(expectedValues.get("strategy")),
//                                Double.valueOf(parameters.get(s).get("penalty")))
//                        );
//                        break;
//                    case PROLONGATION_PERIOD:
//                        m.put(PROLONGATION_PERIOD, setProlongationPeriod(
//                                TermsPeriod.valueOf(expectedValues.get("period")),
//                                Integer.valueOf(parameters.get(s).get("value")))
//                        );
//                        break;
//                    case PROLONGATION_RATE:
//                        m.put(PROLONGATION_RATE, setProlongationRate(
//                                AccrualStrategy.valueOf(expectedValues.get("strategy")),
//                                Double.valueOf(parameters.get(s).get("rate")))
//                        );
//                        break;
//                    case GRACE_PERIOD:
//                        m.put(GRACE_PERIOD, setGracePeriod(
//                                TermsPeriod.valueOf(expectedValues.get("period")),
//                                Integer.valueOf(parameters.get(s).get("value")))
//                        );
//                        break;
//                    default:
//                        throw new InvalidProductConfigurationException(s);
//                }
//            }
//        return m;
//    }







    //    /**
//     * Method validates and sets amount extreme values
//     * @param min minimum amount
//     * @param max maximum amount
//     *
//     * @return map (key-value pair), where key - option name, value - option value
//     * if at least one value is <code>null</code>, configuration will be ignored
//     * @throws InvalidProductConfigurationException when consists are <b>not positive</b>  value
//     */
//    default Map<String, Object> setAmount(Double min, Double max) {
//        if(min == null || max == null) return Map.of("min", 0, "max", 0);
//        if (min <= 0 || min.isInfinite()|| min.isNaN())
//            throw new InvalidProductConfigurationException(AMOUNT, new String[]{"min"});
//        if (max <= 0 || max.isInfinite()|| max.isNaN())
//            throw new InvalidProductConfigurationException(AMOUNT, new String[]{"max"});
//        return Map.of("min", min, "max", max);
//    }
//
//    /**
//     * Method validates and sets terms extreme values and time unit of terms period:
//     * @param period variant of time unit from {@link TermsPeriod};
//     * @param min minimum term;
//     * @param max maximum term;
//     *
//     * @return map (key-value pair), where key - option name, value - option value
//     * if at least one value is <code>null</code>, configuration will be ignored
//     * @throws InvalidProductConfigurationException when consists <b>not positive</b> value
//     */
//    default Map<String, Object> setTerms(TermsPeriod period, Integer min, Integer max) {
//        if(period == null || min == null ||  max == null)
//            return Map.of("period", TermsPeriod.INF, "min", 0, "max", 0);
//        if (min <= 0 || max <= 0)
//            throw new InvalidProductConfigurationException(TERMS, new String[]{"min", "max"});
//        return Map.of("period", period, "min", min, "max", max);
//    }
//
//    /**
//     * Method validates and sets fee value
//     * @param strategy variant of accrual strategy from {@link AccrualStrategy}
//     * @param fee value of loan commission
//     *
//     * @return map (key-value pair), where key - option name, value - option value
//     * if at least one value is <code>null</code>, configuration will be ignored
//     * @throws InvalidProductConfigurationException when value is <b>not positive</b> or <b>uncountable</b>
//     */
//    default Map<String, Object> setFee(AccrualStrategy strategy, Double fee) {
//        if(strategy == null || fee == null) return Map.of("strategy", INF, "fee", 0.);
//        if (fee <= 0 || fee.isInfinite() || fee.isNaN())
//            throw new InvalidProductConfigurationException(FEE, new String[]{"fee"});
//        return Map.of("strategy", strategy, "fee", fee);
//    }
//
//    /**
//     * Method validates and sets loan interests rate
//     * @param strategy variant of accrual strategy from {@link AccrualStrategy}
//     * @param rate value of loan interests rate
//     *
//     * @return map (key-value pair), where key - option name, value - option value
//     * if at least one value is <code>null</code>, configuration will be ignored
//     * @throws InvalidProductConfigurationException value is <b>not positive</b> or <b>uncountable</b>
//     */
//    default Map<String, Object> setRate(AccrualStrategy strategy, Double rate) {
//        if(strategy == null || rate == null) return Map.of("strategy", INF, "rate", 0.);
//        if (rate <= 0 || rate.isInfinite() || rate.isNaN())
//            throw new InvalidProductConfigurationException(RATE, new String[]{"rate"});
//        return Map.of("strategy", strategy, "rate", rate);
//    }
//
//    /**
//     * Method validates and sets loan penalty
//     * @param strategy variant of accrual strategy from {@link AccrualStrategy}
//     * @param penalty value of loan interests rate
//     *
//     * @return map (key-value pair), where key - option name, value - option
//     * if at least one value is <code>null</code>, configuration will be ignored
//     * @throws InvalidProductConfigurationException when value is <b>not positive</b> or <b>uncountable</b>
//     */
//    default Map<String, Object> setPenalty(AccrualStrategy strategy, Double penalty) {
//        if(strategy == null || penalty == null) return Map.of("strategy", INF, "penalty", 0.);
//        if (penalty <= 0 || penalty.isInfinite() || penalty.isNaN())
//            throw new InvalidProductConfigurationException(PENALTY, new String[]{"penalty"});
//        return Map.of("strategy", strategy, "penalty", penalty);
//    }
//
//    /**
//     * Method validates and sets order and strategy of prolongation
//     * @param strategy type of conditions for activate prolongation from {@link ProlongationStrategy}
//     * @param value value, which perform different role depending on <code>strategy</code>
//     *
//     * @return map (key-value pair), where key - option name, value - option value
//     * if at least one value is <code>null</code>, configuration will be ignored
//     * @throws InvalidProductConfigurationException when value is <b>not positive</b> or <b>uncountable</b>
//     */
//    default Map<String, Object> setProlongationOrder(ProlongationStrategy strategy, Double value) {
//        if(strategy == null || value == null) return Map.of("strategy", INF, "value", 0.);
//        if(strategy == FOR_EACH_PERIOD_UNIT)
//            return Map.of("strategy", strategy);
//        if (value <= 0 || value.isInfinite() || value.isNaN())
//            throw new InvalidProductConfigurationException(PROLONGATION_ORDER, new String[]{"value"});
//        return Map.of("strategy", strategy, "value", value);
//    }
//
//    /**
//     * Method validates and sets terms and time unit of terms period on prolongation:
//     * @param period variant of time unit from {@link TermsPeriod};
//     * @param value value of terms
//     *
//     * @return map (key-value pair), where key - option name, value - option value
//     * if at least one value is <code>null</code>, configuration will be ignored
//     * @throws InvalidProductConfigurationException when value is <b>not positive</b>
//     */
//    default Map<String, Object> setProlongationPeriod(TermsPeriod period, Integer value) {
//        if(period == null || value == null) return Map.of("period", TermsPeriod.INF, "value", 0);
//        if(value <= 0)
//            throw new InvalidProductConfigurationException(PROLONGATION_PERIOD, new String[]{"value"});
//        return Map.of("period", period, "value", value);
//    }
//
//    /**
//     * Method validates and sets loan interests rate on prolongation
//     * @param strategy variant of accrual strategy from {@link AccrualStrategy}
//     * @param rate value of interests rate
//     *
//     * @return map (key-value pair), where key - option name, value - option value
//     * if at least one value is <code>null</code>, configuration will be ignored
//     * @throws InvalidProductConfigurationException value is <b>not positive</b> or <b>uncountable</b>
//     */
//    default Map<String, Object> setProlongationRate(AccrualStrategy strategy, Double rate) {
//        if(strategy == null || rate == null) return Map.of("strategy", INF, "rate", 0.);
//        if (rate <= 0 || rate.isInfinite() || rate.isNaN())
//            throw new InvalidProductConfigurationException(PROLONGATION_RATE, new String[]{"rate"});
//        return Map.of("strategy", strategy, "rate", rate);
//    }
//
//    /**
//     * Method validates and sets terms and time unit of grace period:
//     * @param period variant of time unit from {@link TermsPeriod};
//     * @param value value of period
//     *
//     * @return map (key-value pair), where key - option name, value - option value
//     * if at least one value is <code>null</code>, configuration will be ignored
//     * @throws InvalidProductConfigurationException when value is <b>not positive</b>
//     */
//    default Map<String, Object> setGracePeriod(TermsPeriod period, Integer value) {
//        if(period == null || value == null) return Map.of("period", TermsPeriod.INF, "value", 0);
//        if(value <= 0)
//            throw new InvalidProductConfigurationException(GRACE_PERIOD, new String[]{"value"});
//        return Map.of("period", period, "value", value);
//    }
//
//    default Map<String, Object> setComplexRate() {
//        return null;
//    }
//
//    default Map<String, Object> setComplexPenalty() {
//        return null;
//    }
//
//    default Map<String, Object> clear(ProductProperty p) {
//        return configure(p, null, null, null);
//    }
//
//    default Map<ProductProperty, Map<String, Object>> clearAll() {
//        Map<ProductProperty, Map<String, Object>> m = new HashMap<>();
//        for (ProductProperty p: ProductProperty.values()) {
//            m.put(p,clear(p));
//        }
//        return m;
//    }
}
