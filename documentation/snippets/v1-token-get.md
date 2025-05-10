```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.Token;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    Token response = saladCloudImdsSdk.metadata.getToken();

    System.out.println(response);
  }
}

```
