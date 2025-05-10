package com.salad.cloud.imdssdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.salad.cloud.imdssdk.config.SaladCloudImdsSdkConfig;
import com.salad.cloud.imdssdk.exceptions.ApiException;
import com.salad.cloud.imdssdk.http.Environment;
import com.salad.cloud.imdssdk.http.HttpMethod;
import com.salad.cloud.imdssdk.http.ModelConverter;
import com.salad.cloud.imdssdk.http.util.RequestBuilder;
import com.salad.cloud.imdssdk.models.DeletionCost;
import com.salad.cloud.imdssdk.models.ReallocatePrototype;
import com.salad.cloud.imdssdk.models.Status;
import com.salad.cloud.imdssdk.models.Token;
import com.salad.cloud.imdssdk.validation.ViolationAggregator;
import com.salad.cloud.imdssdk.validation.exceptions.ValidationException;
import com.salad.cloud.imdssdk.validation.validators.modelValidators.DeletionCostValidator;
import com.salad.cloud.imdssdk.validation.validators.modelValidators.ReallocatePrototypeValidator;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * MetadataService Service
 */
public class MetadataService extends BaseService {

  public MetadataService(@NonNull OkHttpClient httpClient, SaladCloudImdsSdkConfig config) {
    super(httpClient, config);
  }

  /**
   * Get Container Instance Deletion Cost
   *
   * @return response of {@code DeletionCost}
   */
  public DeletionCost getDeletionCost() throws ApiException {
    Request request = this.buildGetDeletionCostRequest();
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<DeletionCost>() {});
  }

  /**
   * Get Container Instance Deletion Cost
   *
   * @return response of {@code CompletableFuture<DeletionCost>}
   */
  public CompletableFuture<DeletionCost> getDeletionCostAsync() throws ApiException {
    Request request = this.buildGetDeletionCostRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<DeletionCost>() {})
    );
  }

  private Request buildGetDeletionCostRequest() {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v1/deletion-cost"
    ).build();
  }

  /**
   * Replace Container Instance Deletion Cost
   *
   * @param deletionCost {@link DeletionCost} Request Body
   * @return response of {@code DeletionCost}
   */
  public DeletionCost replaceDeletionCost(@NonNull DeletionCost deletionCost) throws ApiException, ValidationException {
    Request request = this.buildReplaceDeletionCostRequest(deletionCost);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<DeletionCost>() {});
  }

  /**
   * Replace Container Instance Deletion Cost
   *
   * @param deletionCost {@link DeletionCost} Request Body
   * @return response of {@code CompletableFuture<DeletionCost>}
   */
  public CompletableFuture<DeletionCost> replaceDeletionCostAsync(@NonNull DeletionCost deletionCost)
    throws ApiException, ValidationException {
    Request request = this.buildReplaceDeletionCostRequest(deletionCost);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<DeletionCost>() {})
    );
  }

  private Request buildReplaceDeletionCostRequest(@NonNull DeletionCost deletionCost) throws ValidationException {
    new ViolationAggregator()
      .add(new DeletionCostValidator("deletionCost").required().validate(deletionCost))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.PUT,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v1/deletion-cost"
    )
      .setJsonContent(deletionCost)
      .build();
  }

  /**
   * Reallocate Container Instance
   *
   * @param reallocatePrototype {@link ReallocatePrototype} Request Body
   * @return response of {@code void}
   */
  public void reallocate(@NonNull ReallocatePrototype reallocatePrototype) throws ApiException, ValidationException {
    Request request = this.buildReallocateRequest(reallocatePrototype);
    this.execute(request);
  }

  /**
   * Reallocate Container Instance
   *
   * @param reallocatePrototype {@link ReallocatePrototype} Request Body
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> reallocateAsync(@NonNull ReallocatePrototype reallocatePrototype)
    throws ApiException, ValidationException {
    Request request = this.buildReallocateRequest(reallocatePrototype);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildReallocateRequest(@NonNull ReallocatePrototype reallocatePrototype) throws ValidationException {
    new ViolationAggregator()
      .add(new ReallocatePrototypeValidator("reallocatePrototype").required().validate(reallocatePrototype))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v1/reallocate"
    )
      .setJsonContent(reallocatePrototype)
      .build();
  }

  /**
   * Recreate Container Instance
   *
   * @return response of {@code void}
   */
  public void recreate() throws ApiException {
    Request request = this.buildRecreateRequest();
    this.execute(request);
  }

  /**
   * Recreate Container Instance
   *
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> recreateAsync() throws ApiException {
    Request request = this.buildRecreateRequest();
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildRecreateRequest() {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v1/recreate"
    ).build();
  }

  /**
   * Restart Container Instance
   *
   * @return response of {@code void}
   */
  public void restart() throws ApiException {
    Request request = this.buildRestartRequest();
    this.execute(request);
  }

  /**
   * Restart Container Instance
   *
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> restartAsync() throws ApiException {
    Request request = this.buildRestartRequest();
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildRestartRequest() {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v1/restart"
    ).build();
  }

  /**
   * Get Container Instance Status
   *
   * @return response of {@code Status}
   */
  public Status getStatus() throws ApiException {
    Request request = this.buildGetStatusRequest();
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<Status>() {});
  }

  /**
   * Get Container Instance Status
   *
   * @return response of {@code CompletableFuture<Status>}
   */
  public CompletableFuture<Status> getStatusAsync() throws ApiException {
    Request request = this.buildGetStatusRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> ModelConverter.convert(response, new TypeReference<Status>() {}));
  }

  private Request buildGetStatusRequest() {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v1/status"
    ).build();
  }

  /**
   * Get Container Instance Token
   *
   * @return response of {@code Token}
   */
  public Token getToken() throws ApiException {
    Request request = this.buildGetTokenRequest();
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<Token>() {});
  }

  /**
   * Get Container Instance Token
   *
   * @return response of {@code CompletableFuture<Token>}
   */
  public CompletableFuture<Token> getTokenAsync() throws ApiException {
    Request request = this.buildGetTokenRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> ModelConverter.convert(response, new TypeReference<Token>() {}));
  }

  private Request buildGetTokenRequest() {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v1/token"
    ).build();
  }
}
