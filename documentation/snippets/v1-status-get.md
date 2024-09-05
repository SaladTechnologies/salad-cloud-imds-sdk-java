```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.ContainerStatus;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    ContainerStatus response = saladCloudImdsSdk.metadataService.getContainerStatus();

    System.out.println(response);
  }
}

```
