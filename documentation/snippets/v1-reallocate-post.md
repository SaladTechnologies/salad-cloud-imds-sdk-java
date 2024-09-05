```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.ReallocateContainer;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    ReallocateContainer reallocateContainer = ReallocateContainer.builder().reason("laborum culpa").build();

    saladCloudImdsSdk.metadataService.reallocateContainer(reallocateContainer);
  }
}

```
