# RDKit Java Example Template

[![License](https://img.shields.io/badge/license-BSD-blue.svg)](https://github.com/rdkit/rdkit/blob/master/LICENSE)
[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://www.oracle.com/java/)
[![Powered by RDKit](https://img.shields.io/badge/Powered%20by-RDKit-3838ff.svg?logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQBAMAAADt3eJSAAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAAFVBMVEXc3NwUFP8UPP9kZP+MjP+0tP////9ZXZotAAAAAXRSTlMAQObYZgAAAAFiS0dEBmFmuH0AAAAHdElNRQfmAwsPGi+MyC9RAAAAQElEQVQI12NgQABGQUEBMENISUkRLKBsbGwEEhIyBgJFsICLC0iIUdnExcUZwnANQWfApKCK4doRBsKtQFgKAQC5Ww1JEHSEkAAAACV0RVh0ZGF0ZTpjcmVhdGUAMjAyMi0wMy0xMVQxNToyNjo0NyswMDowMDzr2J4AAAAldEVYdGRhdGU6bW9kaWZ5ADIwMjItMDMtMTFUMTU6MjY6NDcrMDA6MDBNtmAiAAAAAElFTkSuQmCC)](https://www.rdkit.org/)

This repository is a **Java example template** for experimenting with [RDKit](https://www.rdkit.org/) on the JVM. 
It provides a simple setup for rendering 2D molecular depictions from SMILES strings and serves as a reference project for Java developers integrating RDKit.

---

## Table of Contents

* [Overview](#overview)
* [Features](#features)
* [Prerequisites](#prerequisites)
* [Setup](#setup)
* [Usage](#usage)
* [Project Structure](#project-structure)

---

## Overview

This template project demonstrates:

* How to integrate **RDKit Java bindings** in a Java project
* Rendering 2D chemical structures from SMILES
* Configuring basic drawing options such as canvas size, scaling, and atom indices

It is intended as a **starting point** for Java developers exploring cheminformatics workflows with RDKit.

This project is based upon the [Conan RDKit package](https://github.com/urban233/rdkit-conan-package), which can be used to create the Java SWIG bindings for RDKit.
This means that the other native libraries for macOS and Linux can be built with that project.
Currently, only the **Windows** build is provided in this repository, but it can be easily extended to include the other platforms.

---

## Features

* Load and parse SMILES strings into RDKit molecular objects
* Generate 2D PNG images using `MolDraw2DCairo`
* Display atom indices for easier molecule inspection
* Pre-configured Gradle Kotlin DSL for JVM projects (can be adapted to Maven)
* Cross-platform ready with `java.library.path` configuration

---

## Prerequisites

* **Java 21+**
* **RDKit native libraries** installed and accessible on the JVM library path

> The project expects RDKit `.so` (Linux/macOS) or `.dll` (Windows) files to reside in the `bin/` folder of the project.

---

## Setup

1. Clone the repository:

```bash
git clone https://github.com/urban233/rdkit-java-example-template.git
cd rdkit-java-example-template
```

2. Build and run:

```bash
./gradlew run
```

---

## Usage

The project provides a simple class `DepictSmiles` to generate 2D molecule depictions.

```java
public class Main {
  public static void main(String[] args) {
    // First, load the native library.
    System.loadLibrary("GraphMolWrap");

    // Create an instance of DepictSmiles and generate the 2D PNG.
    DepictSmiles depict = new DepictSmiles();
    depict.create2DPng("c1ccc(C)c(C)c1C");
  }
}
```

This will generate a `test.png` in the project root with the 2D depiction of the molecule.

---

## Project Structure

```
rdkit-java-template/
├─ build.gradle.kts          # Gradle Kotlin DSL build file
├─ settings.gradle.kts
├─ src/
│  ├─ main/java/io/github/urban233/
│     └─ DepictSmiles.java
├─ bin/                      # RDKit native libraries are available here
├─ libs/                     # org.RDKit.jar is available here
└─ README.md
```
