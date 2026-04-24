package com.salad.cloud.imdssdk.validation.validators.modelValidators;

import com.salad.cloud.imdssdk.models.ReplaceDeletionCostParameters;
import com.salad.cloud.imdssdk.validation.Violation;
import com.salad.cloud.imdssdk.validation.ViolationAggregator;

/**
 * Validator implementation for ReplaceDeletionCostParameters model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ReplaceDeletionCostParametersValidator extends AbstractModelValidator<ReplaceDeletionCostParameters> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ReplaceDeletionCostParametersValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ReplaceDeletionCostParametersValidator() {}

  /**
   * Validates the ReplaceDeletionCostParameters model's fields and constraints.
   *
   * @param requestParameters The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ReplaceDeletionCostParameters requestParameters) {
    return new ViolationAggregator()
      .add(new DeletionCostValidator("deletionCost").required().validate(requestParameters.getDeletionCost()))
      .aggregate();
  }
}
