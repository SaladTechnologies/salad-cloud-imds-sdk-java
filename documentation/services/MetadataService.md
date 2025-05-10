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

**Return Type**

`DeletionCost`

**Example Usage Code Snippet**

```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.DeletionCost;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    DeletionCost response = saladCloudImdsSdk.metadata.getDeletionCost();

    System.out.println(response);
  }
}

```

## replaceDeletionCost

Replaces the deletion cost of the current container instance

- HTTP Method: `PUT`
- Endpoint: `/v1/deletion-cost`

**Parameters**

| Name         | Type                                      | Required | Description  |
| :----------- | :---------------------------------------- | :------- | :----------- |
| deletionCost | [DeletionCost](../models/DeletionCost.md) | ✅       | Request Body |

**Return Type**

`DeletionCost`

**Example Usage Code Snippet**

```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.DeletionCost;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    DeletionCost deletionCost = DeletionCost.builder().deletionCost(100L).build();

    DeletionCost response = saladCloudImdsSdk.metadata.replaceDeletionCost(deletionCost);

    System.out.println(response);
  }
}

```

## reallocate

Reallocates the current container instance to another SaladCloud node

- HTTP Method: `POST`
- Endpoint: `/v1/reallocate`

**Parameters**

| Name                | Type                                                    | Required | Description  |
| :------------------ | :------------------------------------------------------ | :------- | :----------- |
| reallocatePrototype | [ReallocatePrototype](../models/ReallocatePrototype.md) | ✅       | Request Body |

**Example Usage Code Snippet**

```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.ReallocatePrototype;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    ReallocatePrototype reallocatePrototype = ReallocatePrototype.builder().reason("Insufficient VRAM").build();

    saladCloudImdsSdk.metadata.reallocate(reallocatePrototype);
  }
}

```

## recreate

Recreates the current container instance on the same SaladCloud node

- HTTP Method: `POST`
- Endpoint: `/v1/recreate`

**Example Usage Code Snippet**

```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    saladCloudImdsSdk.metadata.recreate();
  }
}

```

## restart

Restarts the current container instance on the same SaladCloud node

- HTTP Method: `POST`
- Endpoint: `/v1/restart`

**Example Usage Code Snippet**

```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    saladCloudImdsSdk.metadata.restart();
  }
}

```

## getStatus

Gets the health statuses of the current container instance

- HTTP Method: `GET`
- Endpoint: `/v1/status`

**Return Type**

`Status`

**Example Usage Code Snippet**

```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.Status;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    Status response = saladCloudImdsSdk.metadata.getStatus();

    System.out.println(response);
  }
}

```

## getToken

Gets the identity token of the current container instance

- HTTP Method: `GET`
- Endpoint: `/v1/token`

**Return Type**

`Token`

**Example Usage Code Snippet**

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
