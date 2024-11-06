package com.junenine.composeutils.string

object StringUtils {

    /**
     * Checks if a string is null, empty, or consists only of whitespace characters.
     */
    fun isNullOrBlank(str: String?): Boolean {
        return str.isNullOrBlank()
    }

    /**
     * Capitalizes the first letter of the string.
     */
    fun capitalizeFirstLetter(str: String?): String? {
        return str?.replaceFirstChar { it.uppercaseChar() }
    }

    /**
     * Reverses the given string.
     */
    fun reverse(str: String?): String? {
        return str?.reversed()
    }

    /**
     * Converts a camelCase string to snake_case.
     */
    fun camelToSnake(str: String?): String? {
        return str?.replace(Regex("([a-z])([A-Z])")) {
            "${it.groupValues[1]}_${it.groupValues[2].lowercase()}"
        }
    }

    /**
     * Checks if a string is a palindrome.
     */
    fun isPalindrome(str: String?): Boolean {
        if (str.isNullOrEmpty()) return false
        val cleaned = str.filter { it.isLetterOrDigit() }.lowercase()
        return cleaned == cleaned.reversed()
    }

    /**
     * Truncates a string to a specified length and adds ellipsis if truncated.
     */
    fun truncateWithEllipsis(str: String?, maxLength: Int): String {
        if (str.isNullOrEmpty() || maxLength < 3) return str ?: ""
        return if (str.length > maxLength) str.take(maxLength - 3) + "..." else str
    }

    /**
     * Joins a list of strings with a specified delimiter.
     */
    fun joinWithDelimiter(strings: List<String>?, delimiter: String): String {
        return strings?.joinToString(delimiter) ?: ""
    }

    /**
     * Converts a snake_case string to camelCase.
     */
    fun snakeToCamel(str: String?): String? {
        if (str.isNullOrBlank()) return str
        return str.split('_')
            .joinToString("") { it.lowercase().replaceFirstChar { char -> char.uppercaseChar() } }
            .replaceFirstChar { it.lowercaseChar() }
    }
}
