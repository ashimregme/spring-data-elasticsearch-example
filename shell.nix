{ pkgs ? import <nixpkgs> {} }:

pkgs.mkShell {
  buildInputs = [
    pkgs.jdk21_headless
    pkgs.gradle_8
  ];
}
