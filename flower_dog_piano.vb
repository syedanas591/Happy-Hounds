Public Class Form1

Private Sub Form1_Load(sender As Object, e As EventArgs)

Dim hound1 As String = "Fido"
Dim hound2 As String = "Milo"
Dim hound3 As String = "Buddy"

Dim today As DateTime = DateTime.Now

Dim weight1 As Integer = 20
Dim weight2 As Integer = 25
Dim weight3 As Integer = 55

Dim scoreToday1 As Integer = 0
Dim scoreToday2 As Integer = 0
Dim scoreToday3 As Integer = 0

Dim totalScore1 As Integer = 0
Dim totalScore2 As Integer = 0
Dim totalScore3 As Integer = 0

Dim happyScore1 As Integer = 0
Dim happyScore2 As Integer = 0
Dim happyScore3 As Integer = 0

Dim happyHoundsOverall As Integer = 0

'Calculate scores for each hound
scoreToday1 = weight1 * 2
scoreToday2 = weight2 * 2
scoreToday3 = weight3 * 2

totalScore1 = totalScore1 + scoreToday1
totalScore2 = totalScore2 + scoreToday2
totalScore3 = totalScore3 + scoreToday3

happyScore1 = weight1 * 2 + totalScore1
happyScore2 = weight2 * 2 + totalScore2
happyScore3 = weight3 * 2 + totalScore3

happyHoundsOverall = happyScore1 + happyScore2 + happyScore3

'Print results
Console.WriteLine("Happy Hounds Report for {0}:", today.ToString("MMMM d, yyyy"))
Console.WriteLine("Hound: {0}, Score Today: {1}, Total Score: {2}, Happy Score: {3}", hound1,
scoreToday1, totalScore1, happyScore1)
Console.WriteLine("Hound: {0}, Score Today: {1}, Total Score: {2}, Happy Score: {3}", hound2,
scoreToday2, totalScore2, happyScore2)
Console.WriteLine("Hound: {0}, Score Today: {1}, Total Score: {2}, Happy Score: {3}", hound3, 
scoreToday3, totalScore3, happyScore3)

Console.WriteLine("Happy Hounds Overall Score: {0}", happyHoundsOverall)

End Sub

End Class