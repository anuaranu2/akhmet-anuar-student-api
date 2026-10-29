
#!/bin/bash

LOG_FILE="logs/Akhmet_Anuar_system_report.log"

{
    echo "=================================="
    echo "Student: Anuar Akhmet"
    echo "Date and Time: $(date)"
    echo "Username: $(whoami)"
    echo "=================================="

    echo "Operating System:"
    cat /etc/os-release | grep PRETTY_NAME

    echo "Kernel Version:"
    uname -r

    echo "CPU Information:"
    lscpu | grep -E "Model name|CPU\(s\):"

    echo "Memory Information:"
    free -h

    echo "Disk Usage:"
    df -h

    echo "Available Disk Space:"
    df -h /

    echo "=================================="
} | tee -a "$LOG_FILE"
