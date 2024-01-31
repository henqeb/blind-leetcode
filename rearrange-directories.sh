#!/bin/bash

SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )
dir1="java"
dir2="golang"

# Check if the parent directory exists
if [ ! -d "$SCRIPT_DIR" ]; then
    echo "Parent directory does not exist."
    exit 1
fi

# Loop through all subdirectories
for subdirectory in "$SCRIPT_DIR"/*/; do
    echo "Current subdirectory: ${subdirectory}"
    
    mkdir -p "${subdirectory}${dir1}"
    mkdir -p "${subdirectory}${dir2}"

    # Move existing Java files to dir1
    find "$subdirectory" -maxdepth 1 -type f -name "*.class" -exec mv {} "${subdirectory}${dir1}/" \;
    find "$subdirectory" -maxdepth 1 -type f -name "*.java" -exec mv {} "${subdirectory}${dir1}/" \;

    echo "Moved Java files to dir1 in: ${subdirectory}"
done

echo "Script completed successfully."
