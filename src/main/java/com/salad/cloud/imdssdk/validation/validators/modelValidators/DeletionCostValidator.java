package com.salad.cloud.imdssdk.validation.validators.modelValidators;

import com.salad.cloud.imdssdk.models.DeletionCost;
import com.salad.cloud.imdssdk.validation.Violation;
import com.salad.cloud.imdssdk.validation.ViolationAggregator;
import com.salad.cloud.imdssdk.validation.validators.NumericValidator;

public class DeletionCostValidator extends AbstractModelValidator<DeletionCost> {

  public DeletionCostValidator(String fieldName) {
    super(fieldName);
  }

  public DeletionCostValidator() {}

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
