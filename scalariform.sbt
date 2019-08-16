import scalariform.formatter.preferences._

scalariformPreferences := scalariformPreferences.value
    .setPreference(AlignSingleLineCaseStatements, true)
    .setPreference(DoubleIndentConstructorArguments, true)
    .setPreference(DanglingCloseParenthesis, Preserve)
    .setPreference(AlignArguments, true)
    .setPreference(CompactControlReadability ,true)
    .setPreference(DanglingCloseParenthesis, Force)
    .setPreference(DoubleIndentConstructorArguments, true)
    .setPreference(DoubleIndentMethodDeclaration, true)
    .setPreference(FirstParameterOnNewline, Force)
    .setPreference(IndentLocalDefs, true)
    .setPreference(IndentPackageBlocks, true)
    .setPreference(PlaceScaladocAsterisksBeneathSecondAsterisk,true)
    .setPreference(SpacesAroundMultiImports, true)
    .setPreference(RewriteArrowSymbols, false) //Set thie to true to see the elemental theme like symbol (=>)
