package org.example.service;

import io.grpc.stub.StreamObserver;
import org.example.grpc.User;
import org.example.grpc.userServiceGrpc;

public class UserService extends userServiceGrpc.userServiceImplBase {

    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        String username = request.getUsername();
        String password = request.getPassword();

        User.APIResponse.Builder response = User.APIResponse.newBuilder();
        if(username.equals(password)){
            response.setResponseCode(1).setResponseMessage("Success");
        }else{
            response.setResponseCode(0).setResponseMessage("Fail");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
        super.logout(request, responseObserver);
    }
}
