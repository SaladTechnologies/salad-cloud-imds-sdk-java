```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.GetTokenParameters;
import com.salad.cloud.imdssdk.models.Metadata;
import com.salad.cloud.imdssdk.models.Token;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    GetTokenParameters requestParameters = GetTokenParameters.builder().metadata(Metadata.TRUE).build();

    Token response = saladCloudImdsSdk.metadata.getToken(requestParameters);

    System.out.println(response);
  }
}

```
