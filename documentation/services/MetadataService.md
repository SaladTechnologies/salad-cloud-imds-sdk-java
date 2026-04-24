# MetadataService

A list of all methods in the `MetadataService` service. Click on the method name to view detailed information about that method.

| Methods                                     | Description                                                           |
| :------------------------------------------ | :-------------------------------------------------------------------- |
| [getDeletionCost](#getdeletioncost)         | Gets the deletion cost of the current container instance              |
| [replaceDeletionCost](#replacedeletioncost) | Replaces the deletion cost of the current container instance          |
| [reallocate](#reallocate)                   | Reallocates the current container instance to another SaladCloud node |
| [recreate](#recreate)                       | Recreates the current container instance on the same SaladCloud node  |
| [restart](#restart)                         | Restarts the current container instance on the same SaladCloud node   |
| [getStatus](#getstatus)                     | Gets the health statuses of the current container instance            |
| [getToken](#gettoken)                       | Gets the identity token of the current container instance             |

## getDeletionCost

Gets the deletion cost of the current container instance

- HTTP Method: `GET`
- Endpoint: `/v1/deletion-cost`

**Parameters**

| Name              | Type                                                                | Required | Description               |
| :---------------- | :------------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [GetDeletionCostParameters](../models/GetDeletionCostParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`DeletionCost`

**Example Usage Code Snippet**

```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.DeletionCost;
import com.salad.cloud.imdssdk.models.GetDeletionCostParameters;
import com.salad.cloud.imdssdk.models.Metadata;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    GetDeletionCostParameters requestParameters = GetDeletionCostParameters.builder().metadata(Metadata.TRUE).build();

    DeletionCost response = saladCloudImdsSdk.metadata.getDeletionCost(requestParameters);

    System.out.println(response);
  }
}

```

## replaceDeletionCost

Replaces the deletion cost of the current container instance

- HTTP Method: `PUT`
- Endpoint: `/v1/deletion-cost`

**Parameters**

| Name              | Type                                                                        | Required | Description               |
| :---------------- | :-------------------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ReplaceDeletionCostParameters](../models/ReplaceDeletionCostParameters.md) | ✅       | Request Parameters Object |

**Example Usage Code Snippet**

```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.DeletionCost;
import com.salad.cloud.imdssdk.models.Metadata;
import com.salad.cloud.imdssdk.models.ReplaceDeletionCostParameters;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    DeletionCost deletionCost = DeletionCost.builder().deletionCost(100L).build();

    ReplaceDeletionCostParameters requestParameters = ReplaceDeletionCostParameters.builder()
      .metadata(Metadata.TRUE)
      .deletionCost(deletionCost)
      .build();

    saladCloudImdsSdk.metadata.replaceDeletionCost(requestParameters);
  }
}

```

## reallocate

Reallocates the current container instance to another SaladCloud node

- HTTP Method: `POST`
- Endpoint: `/v1/reallocate`

**Parameters**

| Name              | Type                                                      | Required | Description               |
| :---------------- | :-------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ReallocateParameters](../models/ReallocateParameters.md) | ✅       | Request Parameters Object |

**Example Usage Code Snippet**

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

## recreate

Recreates the current container instance on the same SaladCloud node

- HTTP Method: `POST`
- Endpoint: `/v1/recreate`

**Parameters**

| Name              | Type                                                  | Required | Description               |
| :---------------- | :---------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [RecreateParameters](../models/RecreateParameters.md) | ✅       | Request Parameters Object |

**Example Usage Code Snippet**

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

## restart

Restarts the current container instance on the same SaladCloud node

- HTTP Method: `POST`
- Endpoint: `/v1/restart`

**Parameters**

| Name              | Type                                                | Required | Description               |
| :---------------- | :-------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [RestartParameters](../models/RestartParameters.md) | ✅       | Request Parameters Object |

**Example Usage Code Snippet**

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

## getStatus

Gets the health statuses of the current container instance

- HTTP Method: `GET`
- Endpoint: `/v1/status`

**Parameters**

| Name              | Type                                                    | Required | Description               |
| :---------------- | :------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [GetStatusParameters](../models/GetStatusParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Status`

**Example Usage Code Snippet**

```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.GetStatusParameters;
import com.salad.cloud.imdssdk.models.Metadata;
import com.salad.cloud.imdssdk.models.Status;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    GetStatusParameters requestParameters = GetStatusParameters.builder().metadata(Metadata.TRUE).build();

    Status response = saladCloudImdsSdk.metadata.getStatus(requestParameters);

    System.out.println(response);
  }
}

```

## getToken

Gets the identity token of the current container instance

- HTTP Method: `GET`
- Endpoint: `/v1/token`

**Parameters**

| Name              | Type                                                  | Required | Description               |
| :---------------- | :---------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [GetTokenParameters](../models/GetTokenParameters.md) | ✅       | Request Parameters Object |

**Return Type**

`Token`

**Example Usage Code Snippet**

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
