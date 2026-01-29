/*
 Here's the question from the image:

 Have the function MostFreeTime(strArr) read the strArr parameter being passed
  which will represent a full day and will be filled with events
  that span from time X to time Y in the day.
  The format of each event will be hh:mmAM/PM-hh:mmAM/PM-hh:mmAM/PM. For example,
  strArr may be ["10:00AM-12:30PM","02:00PM-02:45PM","09:10AM-09:50AM"].
   Your program will have to output the longest amount of free time available between
   the start of your first event and the end of your last event
   in the format: hh:mm. The start event should be the earliest event in the day
   and the latest event should be the latest event in the day.
   The output for the previous input would therefore be 01:30
   (with the earliest event in the day starting at 09:10AM and the latest event ending at 02:45PM).
   The input will contain at least 3 events and the events may be out of order.

 Examples:
 Input: ["12:15PM-02:00PM","09:00AM-10:00AM","10:30AM-12:00PM"]
 Output: 00:30

 Input: ["12:15PM-02:00PM","09:00AM-12:11PM","02:02PM-04:00PM"]
 Output: 00:04

*/

function MostFreeTime(strArr) {
    // Convert time format hh:mmAM/PM to minutes since 12:00AM
    function timeToMinutes(time) {
        let match = time.match(/(\d+):(\d+)(AM|PM)/);
        if (!match) return null; // Handle invalid cases

        let [_, hour, min, period] = match;
        hour = parseInt(hour, 10);
        min = parseInt(min, 10);

        if (period === "PM" && hour !== 12) hour += 12;
        if (period === "AM" && hour === 12) hour = 0;

        return hour * 60 + min;
    }

    // Convert intervals to minutes and sort by start time
    let intervals = strArr.map(event => {
        let [start, end] = event.split("-").map(timeToMinutes);
        return { start, end };
    }).sort((a, b) => a.start - b.start);

    // Find the maximum free time gap
    let maxGap = 0;
    for (let i = 1; i < intervals.length; i++) {
        let gap = intervals[i].start - intervals[i - 1].end;
        maxGap = Math.max(maxGap, gap);
    }

    // Convert maxGap from minutes to hh:mm format
    let hours = Math.floor(maxGap / 60);
    let minutes = maxGap % 60;
    return `${String(hours).padStart(2, "0")}:${String(minutes).padStart(2, "0")}`;
}

// Example test
console.log(MostFreeTime(["12:15PM-02:00PM","09:00AM-10:00AM","10:30AM-12:00PM"])); // Output: "00:30"
