package com.salad.cloud.imdssdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.salad.cloud.imdssdk.config.SaladCloudImdsSdkConfig;
import com.salad.cloud.imdssdk.exceptions.ApiError;
import com.salad.cloud.imdssdk.exceptions.SaladCloudImdsErrorException;
import com.salad.cloud.imdssdk.http.Environment;
import com.salad.cloud.imdssdk.http.HttpMethod;
import com.salad.cloud.imdssdk.http.ModelConverter;
import com.salad.cloud.imdssdk.http.util.RequestBuilder;
import com.salad.cloud.imdssdk.models.DeletionCost;
import com.salad.cloud.imdssdk.models.GetDeletionCostParameters;
import com.salad.cloud.imdssdk.models.GetStatusParameters;
import com.salad.cloud.imdssdk.models.GetTokenParameters;
import com.salad.cloud.imdssdk.models.ReallocateParameters;
import com.salad.cloud.imdssdk.models.RecreateParameters;
import com.salad.cloud.imdssdk.models.ReplaceDeletionCostParameters;
import com.salad.cloud.imdssdk.models.RestartParameters;
import com.salad.cloud.imdssdk.models.SaladCloudImdsError;
import com.salad.cloud.imdssdk.models.Status;
import com.salad.cloud.imdssdk.models.Token;
import com.salad.cloud.imdssdk.validation.ViolationAggregator;
import com.salad.cloud.imdssdk.validation.exceptions.ValidationException;
import com.salad.cloud.imdssdk.validation.validators.modelValidators.ReallocateParametersValidator;
import com.salad.cloud.imdssdk.validation.validators.modelValidators.ReplaceDeletionCostParametersValidator;
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

  /**
   * Constructs a new instance of MetadataService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public MetadataService(@NonNull OkHttpClient httpClient, SaladCloudImdsSdkConfig config) {
    super(httpClient, config);
  }

  /**
   * Get Container Instance Deletion Cost
   *
   * @param requestParameters {@link GetDeletionCostParameters} Request Parameters Object
   * @return response of {@code DeletionCost}
   */
  public DeletionCost getDeletionCost(@NonNull GetDeletionCostParameters requestParameters) throws ApiError {
    this.addErrorMapping(403, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(404, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addDefaultErrorMapping(SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    Request request = this.buildGetDeletionCostRequest(requestParameters);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<DeletionCost>() {});
  }

  /**
   * Get Container Instance Deletion Cost
   *
   * @param requestParameters {@link GetDeletionCostParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<DeletionCost>}
   */
  public CompletableFuture<DeletionCost> getDeletionCostAsync(@NonNull GetDeletionCostParameters requestParameters)
    throws ApiError {
    this.addErrorMapping(403, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(404, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addDefaultErrorMapping(SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    Request request = this.buildGetDeletionCostRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<DeletionCost>() {});
    });
  }

  private Request buildGetDeletionCostRequest(@NonNull GetDeletionCostParameters requestParameters) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v1/deletion-cost"
    )
      .setHeader("Metadata", requestParameters.getMetadata().getValue())
      .build();
  }

  /**
   * Replace Container Instance Deletion Cost
   *
   * @param requestParameters {@link ReplaceDeletionCostParameters} Request Parameters Object
   * @return response of {@code void}
   */
  public void replaceDeletionCost(@NonNull ReplaceDeletionCostParameters requestParameters)
    throws ApiError, ValidationException {
    this.addErrorMapping(400, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(403, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(404, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addDefaultErrorMapping(SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    Request request = this.buildReplaceDeletionCostRequest(requestParameters);
    this.execute(request);
  }

  /**
   * Replace Container Instance Deletion Cost
   *
   * @param requestParameters {@link ReplaceDeletionCostParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> replaceDeletionCostAsync(@NonNull ReplaceDeletionCostParameters requestParameters)
    throws ApiError, ValidationException {
    this.addErrorMapping(400, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(403, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(404, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addDefaultErrorMapping(SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    Request request = this.buildReplaceDeletionCostRequest(requestParameters);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildReplaceDeletionCostRequest(@NonNull ReplaceDeletionCostParameters requestParameters)
    throws ValidationException {
    new ViolationAggregator()
      .add(new ReplaceDeletionCostParametersValidator("requestParameters").required().validate(requestParameters))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.PUT,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v1/deletion-cost"
    )
      .setHeader("Metadata", requestParameters.getMetadata().getValue())
      .setJsonContent(requestParameters.getDeletionCost())
      .build();
  }

  /**
   * Reallocate Container Instance
   *
   * @param requestParameters {@link ReallocateParameters} Request Parameters Object
   * @return response of {@code void}
   */
  public void reallocate(@NonNull ReallocateParameters requestParameters) throws ApiError, ValidationException {
    this.addErrorMapping(400, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(403, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(404, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addDefaultErrorMapping(SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    Request request = this.buildReallocateRequest(requestParameters);
    this.execute(request);
  }

  /**
   * Reallocate Container Instance
   *
   * @param requestParameters {@link ReallocateParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> reallocateAsync(@NonNull ReallocateParameters requestParameters)
    throws ApiError, ValidationException {
    this.addErrorMapping(400, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(403, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(404, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addDefaultErrorMapping(SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    Request request = this.buildReallocateRequest(requestParameters);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildReallocateRequest(@NonNull ReallocateParameters requestParameters) throws ValidationException {
    new ViolationAggregator()
      .add(new ReallocateParametersValidator("requestParameters").required().validate(requestParameters))
      .validateAll();
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v1/reallocate"
    )
      .setHeader("Metadata", requestParameters.getMetadata().getValue())
      .setJsonContent(requestParameters.getReallocatePrototype())
      .build();
  }

  /**
   * Recreate Container Instance
   *
   * @param requestParameters {@link RecreateParameters} Request Parameters Object
   * @return response of {@code void}
   */
  public void recreate(@NonNull RecreateParameters requestParameters) throws ApiError {
    this.addErrorMapping(400, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(403, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(404, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addDefaultErrorMapping(SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    Request request = this.buildRecreateRequest(requestParameters);
    this.execute(request);
  }

  /**
   * Recreate Container Instance
   *
   * @param requestParameters {@link RecreateParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> recreateAsync(@NonNull RecreateParameters requestParameters) throws ApiError {
    this.addErrorMapping(400, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(403, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(404, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addDefaultErrorMapping(SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    Request request = this.buildRecreateRequest(requestParameters);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildRecreateRequest(@NonNull RecreateParameters requestParameters) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v1/recreate"
    )
      .setHeader("Metadata", requestParameters.getMetadata().getValue())
      .build();
  }

  /**
   * Restart Container Instance
   *
   * @param requestParameters {@link RestartParameters} Request Parameters Object
   * @return response of {@code void}
   */
  public void restart(@NonNull RestartParameters requestParameters) throws ApiError {
    this.addErrorMapping(400, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(403, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(404, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addDefaultErrorMapping(SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    Request request = this.buildRestartRequest(requestParameters);
    this.execute(request);
  }

  /**
   * Restart Container Instance
   *
   * @param requestParameters {@link RestartParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> restartAsync(@NonNull RestartParameters requestParameters) throws ApiError {
    this.addErrorMapping(400, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(403, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(404, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addDefaultErrorMapping(SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    Request request = this.buildRestartRequest(requestParameters);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildRestartRequest(@NonNull RestartParameters requestParameters) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v1/restart"
    )
      .setHeader("Metadata", requestParameters.getMetadata().getValue())
      .build();
  }

  /**
   * Get Container Instance Status
   *
   * @param requestParameters {@link GetStatusParameters} Request Parameters Object
   * @return response of {@code Status}
   */
  public Status getStatus(@NonNull GetStatusParameters requestParameters) throws ApiError {
    this.addErrorMapping(403, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(404, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addDefaultErrorMapping(SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    Request request = this.buildGetStatusRequest(requestParameters);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Status>() {});
  }

  /**
   * Get Container Instance Status
   *
   * @param requestParameters {@link GetStatusParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Status>}
   */
  public CompletableFuture<Status> getStatusAsync(@NonNull GetStatusParameters requestParameters) throws ApiError {
    this.addErrorMapping(403, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(404, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addDefaultErrorMapping(SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    Request request = this.buildGetStatusRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Status>() {});
    });
  }

  private Request buildGetStatusRequest(@NonNull GetStatusParameters requestParameters) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v1/status"
    )
      .setHeader("Metadata", requestParameters.getMetadata().getValue())
      .build();
  }

  /**
   * Get Container Instance Token
   *
   * @param requestParameters {@link GetTokenParameters} Request Parameters Object
   * @return response of {@code Token}
   */
  public Token getToken(@NonNull GetTokenParameters requestParameters) throws ApiError {
    this.addErrorMapping(403, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(404, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addDefaultErrorMapping(SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    Request request = this.buildGetTokenRequest(requestParameters);
    Response response = this.execute(request);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Token>() {});
  }

  /**
   * Get Container Instance Token
   *
   * @param requestParameters {@link GetTokenParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Token>}
   */
  public CompletableFuture<Token> getTokenAsync(@NonNull GetTokenParameters requestParameters) throws ApiError {
    this.addErrorMapping(403, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addErrorMapping(404, SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    this.addDefaultErrorMapping(SaladCloudImdsError.class, SaladCloudImdsErrorException.class);
    Request request = this.buildGetTokenRequest(requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Token>() {});
    });
  }

  private Request buildGetTokenRequest(@NonNull GetTokenParameters requestParameters) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "v1/token"
    )
      .setHeader("Metadata", requestParameters.getMetadata().getValue())
      .build();
  }
}
