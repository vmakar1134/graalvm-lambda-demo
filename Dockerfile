# Stage 1: Build the native binary using GraalVM
FROM container-registry.oracle.com/graalvm/native-image:21 AS builder

# Set the working directory
WORKDIR /app

# Copy the project files into the builder stage
COPY . .

# Grant execution permissions to the Maven Wrapper
RUN chmod +x ./mvnw

# Build the native image
RUN ./mvnw -Pnative native:compile -DskipTests

# Stage 2: Create the final AWS Lambda image with the native binary
FROM public.ecr.aws/amazonlinux/amazonlinux:2023-minimal

# Copy the native binary from the builder stage
COPY --from=builder /app/target/graalvm-demo /function

# Set the native binary as the entry point
ENTRYPOINT ["/function"]
