#!/bin/bash

# Step 1: Start Docker containers
echo "🛠 Starting Docker containers..."
docker compose up -d

# Optional: Wait for the application to start up
echo "⏳ Waiting for the application to be ready..."
sleep 15  # Adjust based on app boot time

# Step 2: Run Maven tests
echo "✅ Running automation tests..."
mvn clean test

# Step 3: Shut down Docker containers after tests
echo "🧹 Stopping Docker containers..."
docker compose down
