package com.salad.cloud.imdssdk.validation.validators.modelValidators;

import com.salad.cloud.imdssdk.models.SaladCloudImdsError;
import com.salad.cloud.imdssdk.validation.Violation;
import com.salad.cloud.imdssdk.validation.ViolationAggregator;
import com.salad.cloud.imdssdk.validation.validators.NumericValidator;
import com.salad.cloud.imdssdk.validation.validators.StringValidator;

/**
 * Validator implementation for SaladCloudImdsError model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class SaladCloudImdsErrorValidator extends AbstractModelValidator<SaladCloudImdsError> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public SaladCloudImdsErrorValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public SaladCloudImdsErrorValidator() {}

  /**
   * Validates the SaladCloudImdsError model's fields and constraints.
   *
   * @param saladCloudImdsError The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(SaladCloudImdsError saladCloudImdsError) {
    return new ViolationAggregator()
      .add(new StringValidator("code").minLength(1).maxLength(100).optional().validate(saladCloudImdsError.getCode()))
      .add(
        new StringValidator("detail").minLength(1).maxLength(10000).optional().validate(saladCloudImdsError.getDetail())
      )
      .add(
        new StringValidator("instance")
          .minLength(1)
          .maxLength(2048)
          .optional()
          .validate(saladCloudImdsError.getInstance())
      )
      .add(
        new NumericValidator<Long>("status").min(100L).max(599L).optional().validate(saladCloudImdsError.getStatus())
      )
      .add(
        new StringValidator("title").minLength(1).maxLength(10000).optional().validate(saladCloudImdsError.getTitle())
      )
      .add(new StringValidator("type").minLength(1).maxLength(2048).optional().validate(saladCloudImdsError.getType()))
      .aggregate();
  }
}
