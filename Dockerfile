FROM ghcr.io/graalvm/graalvm-community:21 AS builder

# Set the working directory to /build
WORKDIR /build

# Copy the app source code into build directory
COPY . /build

# Make the Maven wrapper executable
RUN chmod +x ./mvnw

# Compile to native image
RUN ./mvnw clean --no-transfer-progress -Pnative native:compile -DskipTests

# Stage 2: Runtime stage

FROM public.ecr.aws/amazonlinux/amazonlinux:2023-minimal

# Copy bytecode into the path to your Lambda function code as per https://repost.aws/knowledge-center/lambda-container-images
COPY --from=builder /build/target/graalvm-demo ${LAMBDA_TASK_ROOT}/

# Set permission
RUN chmod +x ${LAMBDA_TASK_ROOT}/

# Set command to run bytecode
CMD ["./graalvm-demo"]
