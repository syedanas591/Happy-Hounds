Public Class Happy_Hounds

'Initialize global variables
Dim totalPuppies As Integer = 0
Dim totalDogs As Integer = 0
Dim totalRehomed As Integer = 0
Dim totalAdoptions As Integer = 0
Dim totalClients As Integer = 0
Dim currentClient As Integer = 0

Sub Main()

    'Call the Initialize Form function
    InitializeForm()

End Sub

Private Sub InitializeForm()

    'Set the form size and title
    Me.Size = New Size(800, 600)
    Me.Text = "Happy Hounds"

    'Create the menu bar
    Dim MainMenuBar As New MenuStrip

    'Add the File Menu Item
    Dim FileMenuItem As New ToolStripMenuItem("File")
    FileMenuItem.DropDownItems.Add("New Client")
    FileMenuItem.DropDownItems.Add("New Adoption")
    FileMenuItem.DropDownItems.Add("New Rehoming")
    FileMenuItem.DropDownItems.Add("Exit")
    MainMenuBar.Items.Add(FileMenuItem)

    'Add the Reports Menu Item
    Dim ReportsMenuItem As New ToolStripMenuItem("Reports")
    ReportsMenuItem.DropDownItems.Add("Puppies")
    ReportsMenuItem.DropDownItems.Add("Dogs")
    ReportsMenuItem.DropDownItems.Add("Rehomed")
    ReportsMenuItem.DropDownItems.Add("Adoptions")
    ReportsMenuItem.DropDownItems.Add("Clients")
    MainMenuBar.Items.Add(ReportsMenuItem)

    'Add the Help Menu Item
    Dim HelpMenuItem As New ToolStripMenuItem("Help")
    HelpMenuItem.DropDownItems.Add("About")
    MainMenuBar.Items.Add(HelpMenuItem)

    'Add the MainMenuBar to the form
    Me.Controls.Add(MainMenuBar)

    'Show the form
    Me.Show()

End Sub

End Class