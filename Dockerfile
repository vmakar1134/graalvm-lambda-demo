FROM ghcr.io/graalvm/graalvm-community:21 AS builder

# Set the working directory and copy the app source code
WORKDIR /build
COPY . .

# Compile to native image
RUN chmod +x mvnw && ./mvnw clean --no-transfer-progress -Pnative native:compile -DskipTests

# Stage 2: Runtime stage
FROM public.ecr.aws/amazonlinux/amazonlinux:2023-minimal

# Copy bytecode into the path to your Lambda function code as per https://repost.aws/knowledge-center/lambda-container-images
COPY --from=builder /build/target/graalvm-demo ${LAMBDA_TASK_ROOT}/

# Set permission
RUN chmod +x ${LAMBDA_TASK_ROOT}/

# Copy bootstrap into dynamic lambda path
COPY --from=builder /build/bootstrap ${LAMBDA_TASK_ROOT}/

# Set command to run bytecode
ENTRYPOINT ["./graalvm-demo"]
