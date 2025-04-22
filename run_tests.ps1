# Step 1: Start Docker containers
Write-Host "🛠 Starting Docker containers..."
docker compose up -d

# Optional: Wait for the application to start up
Write-Host "⏳ Waiting for the application to be ready..."
Start-Sleep -Seconds 15  # Adjust as needed

# Step 2: Run Maven tests
Write-Host "✅ Running automation tests..."
mvn clean test

# Step 3: Shut down Docker containers after tests
#Write-Host "🧹 Stopping Docker containers..."
#docker compose down
