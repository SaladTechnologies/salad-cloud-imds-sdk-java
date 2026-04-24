```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.Metadata;
import com.salad.cloud.imdssdk.models.RestartParameters;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    RestartParameters requestParameters = RestartParameters.builder().metadata(Metadata.TRUE).build();

    saladCloudImdsSdk.metadata.restart(requestParameters);
  }
}

```
