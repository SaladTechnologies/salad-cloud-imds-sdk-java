```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.ContainerToken;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    ContainerToken response = saladCloudImdsSdk.metadataService.getContainerToken();

    System.out.println(response);
  }
}

```
