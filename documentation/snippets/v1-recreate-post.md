```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.Metadata;
import com.salad.cloud.imdssdk.models.RecreateParameters;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    RecreateParameters requestParameters = RecreateParameters.builder().metadata(Metadata.TRUE).build();

    saladCloudImdsSdk.metadata.recreate(requestParameters);
  }
}

```
