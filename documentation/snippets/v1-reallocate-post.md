```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.Metadata;
import com.salad.cloud.imdssdk.models.ReallocateParameters;
import com.salad.cloud.imdssdk.models.ReallocatePrototype;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    ReallocatePrototype reallocatePrototype = ReallocatePrototype.builder().reason("Insufficient VRAM").build();

    ReallocateParameters requestParameters = ReallocateParameters.builder()
      .metadata(Metadata.TRUE)
      .reallocatePrototype(reallocatePrototype)
      .build();

    saladCloudImdsSdk.metadata.reallocate(requestParameters);
  }
}

```
