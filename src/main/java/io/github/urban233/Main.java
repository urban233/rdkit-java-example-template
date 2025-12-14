// -------------------------------------------------------------------------- //
// This file contains source code for the RDKit Java example
// copyright (c) 2025 by Martin Urban.
// It is unlawful to modify or remove this copyright notice.
// Please see the accompanying LICENSE file for further information.
// -------------------------------------------------------------------------- //
package io.github.urban233;

/**
 * Entry point for the application.
 *
 * <p>
 * This class initializes the necessary native library and demonstrates the
 * usage of the {@link DepictSmiles} class to generate a 2D depiction of a
 * chemical structure from a given SMILES string. The resulting image is saved
 * as a PNG file in the current working directory.
 * </p>
 *
 * <p>
 * Behavior:
 * <ul>
 *   <li>Loads the required native RDKit library for molecular processing and drawing.</li>
 *   <li>Creates an instance of the {@link DepictSmiles} class.</li>
 *   <li>Generates and outputs a 2D depiction of a molecule defined by the SMILES
 *       string "c1ccc(C)c(C)c1C".</li>
 * </ul>
 * </p>
 *
 * <p>
 * Note:
 * Ensure that the native RDKit library ("GraphMolWrap") is correctly installed
 * and available on the JVM library path before execution.
 * </p>
 *
 * @throws UnsatisfiedLinkError If the native library cannot be loaded.
 * @throws RuntimeException If any error occurs during the generation of the molecular depiction.
 */
public class Main {
  public static void main(String[] args) {
    // First, load the native library.
    System.loadLibrary("GraphMolWrap");

    // Create an instance of DepictSmiles and generate the 2D PNG.
    DepictSmiles depict = new DepictSmiles();
    depict.create2DPng("c1ccc(C)c(C)c1C");
  }
}
