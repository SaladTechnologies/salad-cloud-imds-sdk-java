package com.salad.cloud.imdssdk.validation.validators.modelValidators;

import com.salad.cloud.imdssdk.models.DeletionCost;
import com.salad.cloud.imdssdk.validation.Violation;
import com.salad.cloud.imdssdk.validation.ViolationAggregator;
import com.salad.cloud.imdssdk.validation.validators.NumericValidator;

/**
 * Validator implementation for DeletionCost model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class DeletionCostValidator extends AbstractModelValidator<DeletionCost> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public DeletionCostValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public DeletionCostValidator() {}

  /**
   * Validates the DeletionCost model's fields and constraints.
   *
   * @param deletionCost The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(DeletionCost deletionCost) {
    return new ViolationAggregator()
      .add(
        new NumericValidator<Long>("deletionCost")
          .min(-2147483648L)
          .max(2147483647L)
          .required()
          .validate(deletionCost.getDeletionCost())
      )
      .aggregate();
  }
}
