package com.pm.patientservice.grpc;


import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BillingServiceGrpcClient {

    private final BillingServiceGrpc.BillingServiceBlockingStub blockingStub;

    //localhost:9001/BillingService/CreatePatientAccount
    //aws.grpc.123123/BillingService/CreatePatientAccount
    public BillingServiceGrpcClient(
            String serverAddress,
            int serverPort
    ){
        log.info("Connecting to Billing Service GRPC service at {} : {}", serverAddress , serverPort);

        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress,serverPort).usePlaintext().build();

        blockingStub = BillingServiceGrpc.newBlockingStub(channel);

    }

    public BillingResponse createBillingAccount(String patientId, String name,
                                                String email) {

        BillingRequest request = BillingRequest.newBuilder().setPatientId(patientId)
                .setName(name).setEmail(email).build();

        BillingResponse response = blockingStub.createBillingAccount(request);
        log.info("Received response from billing service via GRPC: {}", response);
        return response;
    }

}
