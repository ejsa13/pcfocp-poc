param ($appname, $project)

Copy-Item configmap-template.yaml configmap.yaml
Get-Content app.properties | ForEach-Object {'    ' + $_} | Add-Content configmap.yaml

if (($null -eq $env:OCP_APP_NAME) -and ($null -eq $appname)) {
    $OCP_APP_NAME = "config-client"
}
elseif ($null -ne $appname) {
    $OCP_APP_NAME = $appname
}
else {
    $OCP_PROJECT = $env:OCP_APP_NAME
}

if (($null -eq $env:OCP_PROJECT) -and ($null -eq $project)) { 
    $OCP_PROJECT = "poc" 
}
elseif ($null -ne $project) {
    $OCP_PROJECT = $project
}
else {
    $OCP_PROJECT = $env:OCP_PROJECT
}

((Get-Content -path configmap.yaml -Raw) -replace 'OCP_APP_NAME',$OCP_APP_NAME) | Set-Content -Path configmap.yaml
((Get-Content -path configmap.yaml -Raw) -replace 'OCP_PROJECT',$OCP_PROJECT) | Set-Content -Path configmap.yaml

Remove-Item app.properties