```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.DeletionCost;
import com.salad.cloud.imdssdk.models.Metadata;
import com.salad.cloud.imdssdk.models.ReplaceDeletionCostParameters;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    DeletionCost deletionCost = DeletionCost.builder().deletionCost(100L).build();

    ReplaceDeletionCostParameters requestParameters = ReplaceDeletionCostParameters.builder()
      .metadata(Metadata.TRUE)
      .deletionCost(deletionCost)
      .build();

    saladCloudImdsSdk.metadata.replaceDeletionCost(requestParameters);
  }
}

```
