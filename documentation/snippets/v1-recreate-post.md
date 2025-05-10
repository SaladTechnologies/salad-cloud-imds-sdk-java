```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    saladCloudImdsSdk.metadata.recreate();
  }
}

```
