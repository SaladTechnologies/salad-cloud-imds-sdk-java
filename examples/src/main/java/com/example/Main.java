package com.example;

import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.exceptions.ApiException;
import com.salad.cloud.imdssdk.models.DeletionCost;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    try {
      DeletionCost response = saladCloudImdsSdk.metadata.getDeletionCost();

      System.out.println(response);
    } catch (ApiException e) {
      e.printStackTrace();
    }

    System.exit(0);
  }
}
