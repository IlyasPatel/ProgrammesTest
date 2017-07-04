# Overview

The BBC have a service which provides programme information and schedules.

This is a legacy system and is currently missing tests.

Using the following business requirements listed below, use any Java library to create a suite of automated tests
to interrogate the BbcProgrammeService.

# Business Requirements
Use Cases:

## Lookup a programme by Id
* Usage BbcProgrammeService.find(123)
* An IllegalArgumentException should be thrown if a programme id is not found.

## Retrieve programmes which are scheduled in the next 3, 7 or 14 days.
* Usage BbcProgrammeService.findProgrammesScheduled(NumberOfDays.THREE)
* If there are no programmes available, an empty Map will be returned.

## Background
* BbcProgrammeService uses an ScheduleService which is not maintained by our team but has a well defined interface.
* The programmes exist in a database and we have provided an empty, in-memory implementation for running with the automated build.
