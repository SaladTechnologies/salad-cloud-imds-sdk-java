```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.DeletionCost;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    DeletionCost deletionCost = DeletionCost.builder().deletionCost(100L).build();

    DeletionCost response = saladCloudImdsSdk.metadata.replaceDeletionCost(deletionCost);

    System.out.println(response);
  }
}

```
