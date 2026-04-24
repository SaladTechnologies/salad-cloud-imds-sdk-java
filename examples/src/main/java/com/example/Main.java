package com.example;

import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.exceptions.ApiError;
import com.salad.cloud.imdssdk.models.DeletionCost;
import com.salad.cloud.imdssdk.models.GetDeletionCostParameters;
import com.salad.cloud.imdssdk.models.Metadata;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    GetDeletionCostParameters requestParameters = GetDeletionCostParameters.builder().metadata(Metadata.TRUE).build();

    try {
      DeletionCost response = saladCloudImdsSdk.metadata.getDeletionCost(requestParameters);

      System.out.println(response);
    } catch (ApiError e) {
      e.printStackTrace();
    }

    System.exit(0);
  }
}
