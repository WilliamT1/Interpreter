# Interpreter
Interprets a simple form of the Lua scripting language. Work in progress

GRAMMAR FOR THE MINI-LUA LANGUAGE

<program>→ function id( ) <block>end

<block>→ <statement>|<statement><block>

<statement>→<if_statement>|<assignment_statement>|<while_statement>|<print_statement>|<repeat_statement>

<if_statement>→ if<boolean_expression>then<block>else <block>end

<while_statement>→while <boolean_expression>do<block>end

<assignment_statement>→id<assignment_operator><arithmetic_expression>

<repeat_statement>→repeat<block>until<boolean_expression>

<print_statement>→ print ( <arithmetic_expression>)

<boolean_expression>→<relative_op><arithmetic_expression><arithmetic_expression>

<relative_op>→ le_operator|lt_operator|ge_operator|gt_operator|eq_operator|ne_operator

<arithmetic_expression>→ <id>|<literal_integer>|<arithmetic_op><arithmetic_expression><arithmetic_expression>

<arithmetic_op>→ add_operator|sub_operator|mul_operator|div_operator